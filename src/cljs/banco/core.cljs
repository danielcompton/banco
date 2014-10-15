(ns banco.core
  (:require [banco.calculations :as calc]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defonce app-state (atom {:text "Hello Banco!"}))

(defn main []
  (om/root
    (fn [app owner]
      (reify
        om/IRender
        (render [_]
          (dom/h2 nil (calc/calculate-tax 100 100 100))
          #_(dom/h2 nil (:text app))

          )))
    app-state
    {:target (. js/document (getElementById "app"))}))
