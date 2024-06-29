(ns lagenorhynque.ch05-points-inside-circles-test
  (:require
   [cats.builtin]
   [cats.core :as m]
   [clojure.test :as t]
   [lagenorhynque.ch05-points-inside-circles :as sut]
   [lagenorhynque.ch05-points2d3d :as points2d3d]))

(t/deftest test-is-inside
  (t/testing "is-inside?"
    (let [points [(points2d3d/->Point 5 2)
                  (points2d3d/->Point 1 1)]
          risky-radiuses [-10 0 2]]
      (t/is (= ["#lagenorhynque.ch05_points2d3d.Point{:x 1, :y 1} is within a radius of 2"]
               (for [r (filter pos? risky-radiuses)
                     point (filter #(sut/is-inside? % r) points)]
                 (str (pr-str point) " is within a radius of " r))))
      (t/is (= ["#lagenorhynque.ch05_points2d3d.Point{:x 1, :y 1} is within a radius of 2"]
               (m/mlet [r (filter pos? risky-radiuses)
                        point (filter #(sut/is-inside? % r) points)]
                 (m/return (str (pr-str point) " is within a radius of " r)))))
      (t/is (= ["#lagenorhynque.ch05_points2d3d.Point{:x 1, :y 1} is within a radius of 2"]
               (for [r risky-radiuses
                     :when (pos? r)
                     point points
                     :when (sut/is-inside? point r)]
                 (str (pr-str point) " is within a radius of " r))))
      (t/is (= ["#lagenorhynque.ch05_points2d3d.Point{:x 1, :y 1} is within a radius of 2"]
               (m/mlet [r risky-radiuses
                        :when (pos? r)
                        point points
                        :when (sut/is-inside? point r)]
                 (m/return (str (pr-str point) " is within a radius of " r)))))
      (t/is (= ["#lagenorhynque.ch05_points2d3d.Point{:x 1, :y 1} is within a radius of 2"]
               (for [r risky-radiuses
                     valid-radius (sut/validate-radius r)
                     point points
                     in-point (sut/inside-filter point valid-radius)]
                 (str (pr-str in-point) " is within a radius of " valid-radius))))
      (t/is (= ["#lagenorhynque.ch05_points2d3d.Point{:x 1, :y 1} is within a radius of 2"]
               (m/mlet [r risky-radiuses
                        valid-radius (sut/validate-radius r)
                        point points
                        in-point (sut/inside-filter point valid-radius)]
                 (m/return (str (pr-str in-point) " is within a radius of " valid-radius))))))))
