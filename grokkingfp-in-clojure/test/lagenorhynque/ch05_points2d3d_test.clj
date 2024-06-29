(ns lagenorhynque.ch05-points2d3d-test
  (:require
   [cats.builtin]
   [cats.core :as m]
   [clojure.test :as t]
   [lagenorhynque.ch05-points2d3d :as sut]))

(t/deftest test-Point
  (t/testing "Point"
    ;; 5.12 実習：入れ子のflatMap
    (t/is (= [(sut/->Point 1 -2) (sut/->Point 1 7)]
             (mapcat (fn [x] (map (fn [y] (sut/->Point x y))
                                  [-2 7]))
                     [1])))
    (t/is (= 3
             (count (mapcat (fn [x] (map (fn [y] (sut/->Point x y))
                                         [-2 7 10]))
                            [1]))))
    (t/is (= 4
             (count (mapcat (fn [x] (map (fn [y] (sut/->Point x y))
                                         [-2 7]))
                            [1 2]))))
    (t/is (= 6
             (count (mapcat (fn [x] (map (fn [y] (sut/->Point x y))
                                         [-2 7 10]))
                            [1 2]))))
    (t/is (= 0
             (count (mapcat (fn [x] (map (fn [y] (sut/->Point x y))
                                         [-2 7]))
                            []))))
    (t/is (= 0
             (count (mapcat (fn [x] (map (fn [y] (sut/->Point x y))
                                         []))
                            [1]))))

    ;; 5.15 コーヒーブレイク：flatMapとfor内包表記
    (let [xs [1]
          ys [-2 7]]
      (t/is (= [(sut/->Point 1 -2) (sut/->Point 1 7)]
               (for [x xs
                     y ys]
                 (sut/->Point x y))))
      (t/is (= [(sut/->Point 1 -2) (sut/->Point 1 7)]
               (m/mlet [x xs
                        y ys]
                 (m/return (sut/->Point x y))))))))

(t/deftest test-Point3d
  (t/testing "Point3d"
    (let [xs [1]
          ys [-2 7]
          zs [3 4]]
      (t/is (= [(sut/->Point3d 1 -2 3)
                (sut/->Point3d 1 -2 4)
                (sut/->Point3d 1 7 3)
                (sut/->Point3d 1 7 4)]
               (for [x xs
                     y ys
                     z zs]
                 (sut/->Point3d x y z))))
      (t/is (= [(sut/->Point3d 1 -2 3)
                (sut/->Point3d 1 -2 4)
                (sut/->Point3d 1 7 3)
                (sut/->Point3d 1 7 4)]
               (m/mlet [x xs
                        y ys
                        z zs]
                 (m/return (sut/->Point3d x y z)))))
      (t/is (= [(sut/->Point3d 1 -2 3)
                (sut/->Point3d 1 -2 4)
                (sut/->Point3d 1 7 3)
                (sut/->Point3d 1 7 4)]
               (mapcat (fn [x] (mapcat (fn [y] (map (fn [z] (sut/->Point3d x y z))
                                                    zs))
                                       ys))
                       xs)))
      (t/is (= [(sut/->Point3d 1 -2 3)
                (sut/->Point3d 1 -2 4)
                (sut/->Point3d 1 7 3)
                (sut/->Point3d 1 7 4)]
               (m/bind xs
                       (fn [x] (m/bind ys
                                       (fn [y] (m/bind zs
                                                       (fn [z] (m/return (sut/->Point3d x y z)))))))))))))
