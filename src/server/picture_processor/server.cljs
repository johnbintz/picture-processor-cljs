(ns picture-processor.server)

; js requires
(def express (js/require "express"))

; the currently running server
(def server (atom nil))

(defn- root-response
  [req res]
  (.send res "made it"))

(defn start
  "Start the app server"
  [port]
  (let [app (express)]
    ; build the routing tree
    (.get app "/" root-response)
    (let [-server (.listen app
                           port
                           #(.log js/console (str "Server listening on port "
                                                  port)))]
      (reset! server -server))))

(defn stop
  "Stop the app server"
  []
  (.close @server)
  (reset! server nil))
