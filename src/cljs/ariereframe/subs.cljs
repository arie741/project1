(ns ariereframe.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub 
  :data
  (fn [db]
    (reaction @db)))