(ns ariereframe.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [ariereframe.handlers]
              [ariereframe.subs]
              [ariereframe.views :as views]
              [ariereframe.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn mount-content []
  (reagent/render [views/arie-panel]
                  (.getElementById js/document "content")))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root)
  (mount-content))
