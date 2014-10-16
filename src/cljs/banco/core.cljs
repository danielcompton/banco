(ns banco.core
  (:require #_[banco.calculations :as calc]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defonce app-state (atom {:text "Hello Banco!"}))

(defn main []
  (om/root
    (fn [app owner]
      (reify
        om/IRender
        (render [_]
          (dom/h2 nil "Your tax rate is $10" #_(calc/calculate-tax :nz :2013-2014 10000))
          #_(dom/h2 nil (:text app))

          )))
    app-state
    {:target (. js/document (getElementById "app"))}))
