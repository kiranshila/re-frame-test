(ns kiranshila.re-frame-test.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 ::get-heading
 #(:name %))

(rf/reg-sub
 ::get-first-name
 #(get-in % [:form :first-name]))

(rf/reg-sub
 ::get-valid-name
 :<- [::get-first-name]
 (fn [first-name _]
   (when first-name
     (if (= first-name "Kiran") first-name "Not Kiran"))))
