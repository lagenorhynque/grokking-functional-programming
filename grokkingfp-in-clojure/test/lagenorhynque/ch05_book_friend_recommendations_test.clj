(ns lagenorhynque.ch05-book-friend-recommendations-test
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch05-book-friend-recommendations :as sut]))

;; 5.7 コーヒーブレイク：リストのリストを処理する

(t/deftest test-recommended-books
  (let [friends ["Alice" "Bob" "Charlie"]
        recommendations (mapcat sut/recommended-books friends)
        authors (mapcat :authors recommendations)]
    (t/testing "recomendations"
      (t/is (= [(sut/->Book "FP in Scala" ["Chiusano" "Bjarnason"])
                (sut/->Book "Get Programming with Scala" ["Sfregola"])
                (sut/->Book "Harry Potter" ["Rowling"])
                (sut/->Book "The Lord of the Rings" ["Tolkien"])]
               recommendations)))
    (t/testing "authors"
      (t/is (= ["Chiusano" "Bjarnason" "Sfregola" "Rowling" "Tolkien"]
               authors)))))
