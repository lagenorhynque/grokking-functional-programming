(ns lagenorhynque.ch05-events-test
  (:require
   [cats.builtin]
   [cats.monad.maybe :as maybe]
   [clojure.test :as t]
   [lagenorhynque.ch05-events :as sut]))

(t/deftest test-parse-long-event
  (t/testing "parse-long-event"
    (t/is (= (maybe/just (sut/->Event "Apollo Program" 1961 1972))
             (sut/parse-long-event "Apollo Program" 1961 1972 10)))
    (t/is (= (maybe/nothing)
             (sut/parse-long-event "World War II" 1939 1945 10)))
    (t/is (= (maybe/nothing)
             (sut/parse-long-event "" 1939 1945 10)))
    (t/is (= (maybe/nothing)
             (sut/parse-long-event "Apollo Program" 1972 1961 10)))))
