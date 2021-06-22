(ns kiranshila.re-frame-test.views
  (:require
   [re-frame.core :as rf]
   [kiranshila.re-frame-test.subs :as subs]
   [kiranshila.re-frame-test.utils :as utils]
   [kiranshila.re-frame-test.events :as events]))

(defn heading []
  (let [head (rf/subscribe [::subs/get-heading])
        first-name (rf/subscribe [::subs/get-valid-name])]
    [:div
     [:h1 "This is " @head]
     (when @first-name [:h3 "Designed for " @first-name])]))

(defn form []
  [:div
   [:form {:on-submit (fn [e]
                        (.preventDefault e)
                        (rf/dispatch
                         [::events/new-form
                          (->> e
                               .-target
                               utils/form->clj)]))}
    [:label {:for :first-name} "First Name"]
    [:input {:type :text
             :name :first-name}]
    [:br]
    [:label {:for :last-name} "Last Name"]
    [:input {:type :text
             :name :last-name}]
    [:br]
    [:label {:for :email} "Email"]
    [:input {:type :email
             :name :email
             :required true}]
    [:br]
    [:input {:type :submit}]]])

(defn main-panel []
  [:div
   [heading]
   [form]])
