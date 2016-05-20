(defproject sicp-clojure "0.1.0-SNAPSHOT"
  :description "Sample Exercises from the book Structure and Interpretation of Computer Programs "
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]  [clj-http "2.0.0"]]
  :main ^:skip-aot sicp-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
