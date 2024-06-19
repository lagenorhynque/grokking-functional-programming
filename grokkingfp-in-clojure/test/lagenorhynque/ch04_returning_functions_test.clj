(ns lagenorhynque.ch04-returning-functions-test
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch04-returning-functions :as sut]))

(t/deftest test-larger-than
  (t/testing "larger-than"
    (t/is (= [5] (filter (sut/larger-than 4) [5 1 2 4 0])))
    (t/is (= [5 2 4] (filter (sut/larger-than 1) [5 1 2 4 0])))))

(t/deftest test-divisible-by
  (t/testing "divisible-by"
    (t/is (= [5 15] (filter (sut/divisible-by 5) [5 1 2 4 15])))
    (t/is (= [2 4] (filter (sut/divisible-by 2) [5 1 2 4 15])))))

(t/deftest test-shorter-than
  (t/testing "shorter-than"
    (t/is (= ["ada"] (filter (sut/shorter-than 4) ["scala" "ada"])))
    (t/is (= ["scala" "ada"] (filter (sut/shorter-than 7) ["scala" "ada"])))))

(t/deftest test-contains-s
  (t/testing "contains-s"
    (t/is (= [] (filter (sut/contains-s 2) ["rust" "ada"])))
    (t/is (= ["rust"] (filter (sut/contains-s 0) ["rust" "ada"])))))
