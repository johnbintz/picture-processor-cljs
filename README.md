# picture-processor

Process a bunch of pictures in nested directories and provide a nice, mobile-
friendly view of them.

## REPL with vim-fireplace and Piggieback

### client-side

* `lein repl`
* In the repl, `(web-start)` to launch a Jetty server on port 3500.
* In the browser, `http://localhost:3500`.
* In vim, `:Connect`, then `:Piggieback (weasel.repl.websocket/repl-env :port 45192)`
* In the browser console, `startRepl(45192)`
* Evaluate away!

### server-side

* `lein repl`
* In the repl, `(start)` to launch a cljs node repl.
* In vim, `:Connect`, then `:Piggieback (weasel.repl.websocket/repl-env :port 45192)`
* In the cljs repl, `(require 'picture-processor.repl)`
* ...and then `(picture-processor.repl/start 45192)`
* Evaluate away!

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
