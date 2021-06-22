(ns kiranshila.re-frame-test.events
  (:require
   [re-frame.core :as rf]
   [kiranshila.re-frame-test.db :as db]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 ::new-form
 (fn [app-db [_ form]]
   (assoc app-db :form form)))
