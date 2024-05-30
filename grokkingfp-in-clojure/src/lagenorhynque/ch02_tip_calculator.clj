(ns lagenorhynque.ch02-tip-calculator
  "第2章 純粋関数"
  (:require
   [clojure.spec.alpha :as s]))

;; 2.10 コーヒーブレイク：純粋関数のリファクタリング
;; 2.19 実習：Scalaで純粋関数を書く

(s/fdef get-tip-percentage
  :args (s/cat :names (s/coll-of string?))
  :ret nat-int?)

(defn get-tip-percentage [names]
  (condp < (count names)
    5 20
    0 10
    0))

(comment

  (get-tip-percentage [])
  (get-tip-percentage ["Alice"])
  (get-tip-percentage ["Alice" "Bob" "Charlie" "Daniel" "Emily"])
  (get-tip-percentage ["Alice" "Bob" "Charlie" "Daniel" "Emily" "Frank"])

  )
