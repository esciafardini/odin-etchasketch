(ns etch.core
  (:require [goog.dom :as dom]
            [goog.events :as events]))

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

#_(defn on-mouse-over [event]
    (let [target (.-target event)]
      (set! (.-style target) "background-color" "red")))

#_(defn add-hover-listener []
    (let [my-div (dom/getElement "my-div")]
      (events/listen my-div "mouseover" on-mouse-over)))

#_(add-hover-listener)

(defn init []
  (dotimes [x (* 40 40)]
    (let [new-div (.createElement js/document "div")]
      (set! (.. new-div -className) "grid-item")
      (.addEventListener new-div "mouseover"
                         #(set! (.. new-div -style -backgroundColor) "white"))
      (.appendChild (get-element-by-id "sketch") new-div)))
  (console-log "initialized"))
