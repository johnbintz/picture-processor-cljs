(ns picture-processor.db)

(def sqlite3 (js/require "sqlite3"))
(def database (aget sqlite3 "Database"))

(def -db (atom nil))

(defn connection
  "Get the current database connection"
  []
  @-db)

(defn open
  "Open the database connection"
  []
  (reset! -db (database. "db/dev.db")))

(defn close
  "Close the database connection"
  []
  (.close @-db)
  (reset! -db nil))

(defn in-series
  "Run SQL commands in series"
  [code]
  (.serialize @-db (code @-db)))

(defn run
  "Run SQL command"
  [cmd & args]
  (let [statement (.prepare @-db cmd)]
    (apply (.run statement & )
    )
  )

(in-series (fn [db]
             (.log js/console (.run db))
             ))
