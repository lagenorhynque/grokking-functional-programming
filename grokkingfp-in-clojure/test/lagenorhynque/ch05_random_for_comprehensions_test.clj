(ns lagenorhynque.ch05-random-for-comprehensions-test
  (:require
   [cats.builtin]
   [cats.core :as m]
   [clojure.test :as t]))

;; 5.29 実習：for内包表記

(t/deftest test-for-comprehension
  (t/testing "for comprehension"
    (t/is (= [1 2 3]
             (for [x [1 2 3]
                   y #{1}]
               (* x y))))
    (t/is (= [1 2 3]
             (m/mlet [x [1 2 3]
                      y #{1}]
               (m/return (* x y)))))
    (t/is (= #{1 2 3}
             (set (for [x #{1 2 3}
                        y [1]]
                    (* x y)))))
    (t/is (= #{1 2 3}
             (set (m/mlet [x #{1 2 3}
                           y [1]]
                    (m/return (* x y))))))
    (t/is (= [0 0 0]
             (for [x [1 2 3]
                   y #{1}
                   z #{0}]
               (* x y z))))
    (t/is (= [0 0 0]
             (m/mlet [x [1 2 3]
                      y #{1}
                      z #{0}]
               (m/return (* x y z)))))))
