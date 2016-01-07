(ns picture-processor.repl
  (:require weasel.repl))

(defn start
  "Start the Weasel repl to connect to vim-fireplace"
  [port]
  (aset js/global "WebSocket" (js/require "ws"))
  (weasel.repl/connect (str "ws://localhost:" port)))
