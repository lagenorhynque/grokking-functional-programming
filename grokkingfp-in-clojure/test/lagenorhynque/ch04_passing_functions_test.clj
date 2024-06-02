(ns lagenorhynque.ch04-passing-functions-test
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch04-passing-functions :as sut]))

(t/deftest test-sort-by-len
  (t/testing "sort by len"
    (t/is (= ["ada" "rust" "scala"] (sort-by sut/len ["scala" "rust" "ada"])))))

(t/deftest test-sort-by-number-of-s
  (t/testing "sort by number-of-s"
    (t/is (= ["ada" "rust"] (sort-by sut/number-of-s ["rust" "ada"])))))

(t/deftest test-sort-by-negative
  (t/testing "sort by negative"
    (t/is (= [5 4 3 2 1] (sort-by sut/negative [5 1 2 4 3])))))

(t/deftest test-sort-by-negative-number-of-s
  (t/testing "sort by negative-number-of-s"
    (t/is (= ["rust" "ada"] (sort-by sut/negative-number-of-s ["ada" "rust"])))))
