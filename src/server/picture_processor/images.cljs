(ns picture-processor.images)

(def fs (js/require "fs"))
(def imagemagick (js/require "imagemagick-native"))

(defn write-file [data path]
  (.writeFileSync fs path data))

(defn read-file [path]
  (.readFileSync fs path))

(defn shrink-image-data
  [data width]
  (.log js/console "here")
  (.convert
    imagemagick
    (clj->js {:srcData data
             :width width
             :height width
             :resizeStyle "aspectfill"}
      )))

(defn create-thumbnail
  "Make a mobile thumbnail from a file path"
  [source target width]

  (-> source
      read-file
      (shrink-image-data width)
      (write-file target)
      ))
