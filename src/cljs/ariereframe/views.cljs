(ns ariereframe.views
    (:require [re-frame.core :as re-frame]))

(def data
  (re-frame/subscribe [:data]))

(defn main-panel []
  (fn []
      [:div @data]))

(defn blogcontent [title content]
  [:li [:ul [:li title] [:li content]]])

(defn arie-panel []
  (fn []
      [:div "Es ist eine " (str @data) " panel"
      [:input {:type "text"
               :on-change #(swap! data conj {:id 3, :title "a", :content (-> % .-target .-value)})}]
      [:ul (map #(blogcontent (:title %) (:content %)) @data)]]))