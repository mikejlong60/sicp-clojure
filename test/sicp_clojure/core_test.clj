(ns sicp-clojure.core-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(deftest a-argcount-test
  (testing "Count the number of arguments to a function."
    (defn argcount
      ([] 0)
      ([x] 1)
      ([x y] 2)
      ([x y & more] (+ (argcount x y) (count more))))

    (is (= (argcount) 0)))
  (is (= (argcount 1) 1))
  (is (= (argcount 1 2) 2))
  (is (= (argcount 1 2 3 4 5) 5))

  )

(deftest a-let-test
  (testing "Understand how let creates named values."
    (defn make-adder [x]
      (let [y x]
        (println "x:" + x + " y:" + y)
        (fn [z] (+ y z))))
    (def add2 (make-adder 2))

    (is (= (add2 4) 6)))
  )

(deftest a-immutability-test
  (comment (testing "conj returns new thing and doesn't change the
   thing to which it is applied."
             (defn some-vector []
               (let [my-vector [1 2 3 4]
                     my-map {:fred "ethel"}
                     my-list (list 4 3 2 1)]
                 (list
                   (conj my-vector 5)
                   (assoc my-map :ricky "lucy")
                   (conj my-list 5)

                   my-vector
                   my-map
                   my-list
                   ))
               )
             (is (= (some-vector) (list ([1 2 3 4] {:fred "ethel"} (4 3 2 1))))))
           )

  (testing "conj returns a new list and doesn't change the
   one to which it is applied."
    (defn some-list []
      (let [my-list (list 4 3 2 1)]
        (list
          (conj my-list 5)
          my-list
          ))
      )
    (is (= (some-list) (list (list 5 4 3 2 1) (list 4 3 2 1)))))


  (testing "conj returns a new vector and doesn't change the
   vector to which it is applied."
    (defn some-vector []
      (let [my-vector [1 2 3 4]]
        (list
          (conj my-vector 5)
          my-vector
          ))
      )
    (is (= (some-vector) (list [1 2 3 4 5] [1 2 3 4]))))


  (testing "assoc returns a new map and doesn't change the
   map to which it is applied."
    (defn some-map []
      (let [my-map {:fred "ethel"}]
        (list
          (assoc my-map :ricky "lucy")
          my-map
          ))
      )
    (is (= (some-map) (list {:fred "ethel", :ricky "lucy"} {:fred "ethel"}))))

  )

