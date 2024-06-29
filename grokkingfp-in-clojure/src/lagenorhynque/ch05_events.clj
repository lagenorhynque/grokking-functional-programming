(ns lagenorhynque.ch05-events
  "第5章 逐次プログラム"
  (:require
   [cats.builtin]
   [cats.core :as m]
   [cats.monad.maybe :as maybe]
   [clojure.spec.alpha :as s]))

;; 5.34 コーヒーブレイク：Optionによる解析

(s/def ::name string?)
(s/def ::start int?)
(s/def ::end int?)
(s/def ::event (s/keys :req-un [::name ::start ::end]))

(defrecord Event [name start end])

(s/fdef validate-name
  :args (s/cat :name string?)
  :ret maybe/maybe?)

(defn validate-name [name]
  (if (seq name)
    (maybe/just name)
    (maybe/nothing)))

(s/fdef validate-end
  :args (s/cat :end int?)
  :ret maybe/maybe?)

(defn validate-end [end]
  (if (< end 3000)
    (maybe/just end)
    (maybe/nothing)))

(s/fdef validate-start
  :args (s/cat :start int?
               :end int?)
  :ret maybe/maybe?)

(defn validate-start [start end]
  (if (<= start end)
    (maybe/just start)
    (maybe/nothing)))

(s/fdef validate-length
  :args (s/cat :start int?
               :end int?
               :min-length int?)
  :ret maybe/maybe?)

(defn validate-length [start end min-length]
  (if (>= (- end start) min-length)
    (maybe/just (- end start))
    (maybe/nothing)))

(defn parse-long-event [name start end min-length]
  (m/mlet [valid-name (validate-name name)
           valid-end (validate-end end)
           valid-start (validate-start start end)
           _ (validate-length start end min-length)]
    (m/return (->Event valid-name valid-start valid-end))))
