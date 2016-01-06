(defproject picture-processor "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljsbuild "1.1.2"]
            [lein-npm "0.6.1"]]
  :source-paths ["src"]
  :npm { :dependencies [[ws "0.4.30"] ]}
  :cljsbuild {
              :builds [{:source-paths ["src"]
                        :compiler {
                                   :target :nodejs
                                   :optimizations :simple}}]}
  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.10"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                                  :init (do
                                          (require 'cljs.repl.node)
                                          (require 'weasel.repl.websocket)
                                          (defn start [] (cemerick.piggieback/cljs-repl (cljs.repl.node/repl-env))))
                                  }}}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [weasel "0.7.0" :exclusions [org.clojure/clojurescript]]
                 [org.clojure/clojurescript "1.7.170"]])
