(ns lagenorhynque.ch04-word-scoring-test
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch04-passing-functions :as pf]
   [lagenorhynque.ch04-word-scoring :as sut]))

(t/deftest test-ranked-words
  (let [words ["ada" "haskell" "scala" "java" "rust"]]
    (t/testing "ranked words by score"
      (t/is (= ["haskell" "rust" "scala" "java" "ada"]
               (sut/ranked-words sut/score words))))
    (t/testing "ranked words by score and bonus"
      (t/is (= ["scala" "haskell" "rust" "java" "ada"]
               (sut/ranked-words #(+ (sut/score %)
                                     (sut/bonus %))
                                 words))))
    (t/testing "ranked words by score, bonus and penalty")
    (t/is (= ["java" "scala" "ada" "haskell" "rust"]
             (sut/ranked-words #(-> (sut/score %)
                                    (+ (sut/bonus %))
                                    (- (sut/penalty %)))
                               words)))))

;; 4.28 実習：map
(t/deftest test-map
  (t/testing "map"
    (t/is (= [5 4 3] (map pf/len ["scala" "rust" "ada"])))
    (t/is (= [1 0] (map pf/number-of-s ["rust" "ada"])))
    (t/is (= [-5 -1 -2 -4 0] (map pf/negative [5 1 2 4 0])))
    (t/is (= [10 2 4 8 0] (map #(* 2 %) [5 1 2 4 0])))))

;; 4.33 実習：filter
(t/deftest test-filter
  (t/testing "filter"
    (t/is (= ["rust" "ada"] (filter #(< (pf/len %) 5) ["scala" "rust" "ada"])))
    (t/is (= [] (filter #(>= (pf/number-of-s %) 3) ["rust" "ada"])))
    (t/is (= [5 1] (filter odd? [5 1 2 4 0])))
    (t/is (= [5] (filter #(> % 4) [5 1 2 4 0])))))
