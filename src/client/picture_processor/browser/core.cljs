(ns picture-processor.browser.core
  (:require [weasel.repl :as repl]
            [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            ))

(aset js/window
      "startRepl"
      (fn [port]
        (when-not (repl/alive?)
          (weasel.repl/connect (str "ws://localhost:" port))))
      )

(def meow (atom 1))

(add-watch meow :key (fn [key ref old-val new-val]
                     (.log js/console new-val)
                     ))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (html [:div data])
      )
    )
  )

(.log js/console @meow)

(reset! meow 2)

(om/root widget meow {:target (.getElementById js/document "app")})
