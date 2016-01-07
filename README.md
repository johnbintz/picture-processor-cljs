# picture-processor

A Clojure library designed to ... well, that part is up to you.

## REPL

### serverside with vim-fireplace and Piggieback

* `lein repl`
* In the repl, `(start)` to launch a cljs repl.
* In vim, `:Connect`, then `:Piggieback (weasel.repl.websocket/repl-env :port 45192)`
* In the cljs repl, `(require 'picture-processor.repl)`
* ...and then `(picture-processor.repl/start 45192)`
* Evaluate away!

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
