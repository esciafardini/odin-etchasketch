(ns etch.core
  (:require [goog.dom :as dom]
            [goog.events :as events]))

(defn event-target-value [e]
  (.-value (.-target e)))

(defn set-sketch-zone! [n]
  (dom/removeChildren (dom/getElement "sketch")) ;no-op on mount
  (dotimes [_ (* n n)] ;read as 64x64
    (let [new-div (dom/createElement "div")
          item-width (/ 360 n)]
      (set! (.. new-div -className) "grid-item")
      (set! (.. new-div -style -width) (str item-width "px"))
      (set! (.. new-div -style -height) (str item-width "px"))
      (events/listen new-div "mouseover" #(set! (.. new-div -style -backgroundColor) "white"))

      (dom/appendChild (dom/getElement "sketch") new-div))))

(defn init []
  (set! (.. (dom/getElement "my-dropdown") -onchange) #(set-sketch-zone! (event-target-value %)))
  (set-sketch-zone! 180))
