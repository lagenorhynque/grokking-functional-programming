(ns lagenorhynque.ch05-book-friend-recommendations
  "第5章 逐次プログラム"
  (:require
   [clojure.spec.alpha :as s]))

;; 5.7 コーヒーブレイク：リストのリストを処理する

(s/def ::title string?)
(s/def ::authors (s/coll-of string?))

(s/def ::book
  (s/keys :req-un [::title ::authors]))

(defrecord Book [title authors])

(defn recommended-books [friend]
  (let [scala [(->Book "FP in Scala" ["Chiusano" "Bjarnason"])
               (->Book "Get Programming with Scala" ["Sfregola"])]
        fiction [(->Book "Harry Potter" ["Rowling"])
                 (->Book "The Lord of the Rings" ["Tolkien"])]]
    (case friend
      "Alice" scala
      "Bob" fiction
      [])))
