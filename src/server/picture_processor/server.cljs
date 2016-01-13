(ns picture-processor.server)

(def express (js/require "express"))
(def server (atom nil))

(defn- root-response
  [req res]
  (.send res "made it"))

(defn start
  "Start the app server"
  [port]
  (let [app (express)]
    (.get app "/" root-response)
    (let [-server (.listen app port #(.log js/console (str "Server listening on port " port)))]
      (reset! server -server)
      (.log js/console @server)
      )))

(defn stop
  "Stop the app server"
  []
  (.close @server)
  (reset! server nil))

(start 3000)
(stop)
(.log js/console @server)
