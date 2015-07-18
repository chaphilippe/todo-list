(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [todo-list.handlers :refer [welcome goodbye about hello calculator]]
            [ring.handler.dump :refer [handle-dump]]))

(defroutes app
           (GET "/" [] welcome)
           (GET "/about" [] about)
           (GET "/goodbye" [] goodbye)
           (GET "/request-info" [] handle-dump)
           (GET "/hello/:name" [] hello)
           (GET "/calculator/:a/:op/:b" [] calculator)
           (not-found "Sorry, page not found"))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty app
                   {:port (Integer. port-number)}))

(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
                   {:port (Integer. port-number)}))