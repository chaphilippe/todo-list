(defproject webdev "0.1.0-SNAPSHOT"
  :description "Simple to do app"
  :url "http://http://clojure-todo-list.herokuapp.com/"
  :license {:name "IntelliJ Public License"
            :url ""}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.4.0-beta2"]
                 [compojure "1.3.4"]
                 [hiccup "1.0.5"]]
  :main todo-list.core
  :min-lein-version "2.0.0"
  :uberjar-name "todo-list.jar"
  :profiles {:dev
             {:main todo-list.core/-dev-main}})