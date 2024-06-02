(ns lagenorhynque.ch03-slicing-and-appending-test
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch03-slicing-and-appending :as sut]))

(t/deftest test-first-two
  (t/is (= ["a" "b"] (sut/first-two ["a" "b" "c"]))))

(t/deftest test-last-two
  (t/is (= ["b" "c"] (sut/last-two ["a" "b" "c"]))))

(t/deftest test-moved-first-two-to-the-end
  (t/is (= ["c" "a" "b"] (sut/moved-first-two-to-the-end ["a" "b" "c"]))))

(t/deftest test-inserted-before-last
  (t/is (= ["a" "c" "b"] (sut/inserted-before-last ["a" "b"] "c"))))
