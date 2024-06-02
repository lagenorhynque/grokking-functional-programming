(ns lagenorhynque.ch03-abbreviate-names-test
  (:require
   [clojure.test :as t]
   [lagenorhynque.ch03-abbreviate-names :as sut]))

(t/deftest test-abbreviate
  (t/is (= "A. Church" (sut/abbreviate "Alonzo Church")))
  (t/is (= "A. Church" (sut/abbreviate "A. Church")))
  (t/is (= "A. Church" (sut/abbreviate "A Church"))))
