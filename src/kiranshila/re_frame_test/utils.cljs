(ns kiranshila.re-frame-test.utils
  (:require [cljs-bean.core :refer [->clj]]))

(defn form->clj [form]
  (let [data (js/FormData. form)]
    (into {} (for [[k v] (.entries data)]
               [(keyword k) (->clj v)]))))
