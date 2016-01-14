(defproject picture-processor "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljsbuild "1.1.2"]
            [lein-npm "0.6.1"]]
  :source-paths ["src/server" "src/client"]
  :npm { :dependencies [[ws "0.4.30"]
                        [imagemagick-native "https://github.com/elad/node-imagemagick-native.git"]
                        [express "4.13.3"]
                        [sqlite3 "3.1.1"]
                        [db-migrate "0.9.23"]]}
  :cljsbuild {
              :builds [{:source-paths ["src/server"]
                        :compiler {
                                   :target :nodejs
                                   :optimizations :simple}}
                      {:source-paths ["src/client"]
                        :compiler {
                                   :output-dir "public/out"
                                   :output-to "public/index.js"
                                   :pretty-print true
                                   :optimizations :whitespace}}
                       ]}
  :profiles {:dev {:source-paths ["dev-src"]
                   :dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.10"]
                                  [ring/ring-core "1.4.0"]
                                  [ring/ring-jetty-adapter "1.4.0"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                                  :init (do
                                          (require 'cljs.repl.node
                                                   'weasel.repl.websocket)
                                          (use 'ring.middleware.file
                                               'ring.adapter.jetty)
                                          (defn web-start []
                                            (run-jetty (wrap-file (fn [request]
                                                         {:status 200
                                                          :body "ok"}
                                                         ) "public")
                                                       {:port 3500}
                                             ))
                                          (defn start [] (cemerick.piggieback/cljs-repl (cljs.repl.node/repl-env))))
                                  }}}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [weasel "0.7.0" :exclusions [org.clojure/clojurescript]]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.omcljs/om "0.9.0"]
                 [sablono "0.3.6"]
                 [cljs-http "0.1.39"]
                 ])
