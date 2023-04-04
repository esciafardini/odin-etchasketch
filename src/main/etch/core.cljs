(ns etch.core
  (:require [goog.dom :as dom]))

;;find sketch div
;;generate 16 items inside of it with class grid-item

(def console-log (.-log js/console))

(defn get-element-by-id [id]
  (.getElementById js/document id))

(defn set-text-content! [div-id text-content]
  (let [div (get-element-by-id div-id)]
    (set! (.. div -textContent) text-content)))

(defn set-img-src! [div-id text]
  (let [div (get-element-by-id div-id)]
    (set! (.. div -src) text)))

(def sketch-div (.getElementById js/document "sketch"))

(defn init []
  #_(.appendChild (get-element-by-id "sketch") (.createElement js/document "div"))
  (dotimes [x 64]
    (let [new-div (.createElement js/document "div")
          _ (set! (.. new-div -className) "grid-item")]
      (.appendChild (get-element-by-id "sketch") new-div)))
  (console-log "initialized"))
