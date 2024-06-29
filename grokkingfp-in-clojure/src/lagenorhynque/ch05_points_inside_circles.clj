(ns lagenorhynque.ch05-points-inside-circles
  "第5章 逐次プログラム"
  (:require
   [clojure.spec.alpha :as s]
   [lagenorhynque.ch05-points2d3d :as points2d3d]))

;; 5.23 コーヒーブレイク：フィルタリングの方法

(s/fdef is-inside?
  :args (s/cat :point ::points2d3d/point
               :radius number?)
  :ret boolean?)

(defn is-inside? [point radius]
  (>= (* radius radius)
      (+ (* (:x point) (:x point))
         (* (:y point) (:y point)))))

(s/fdef inside-filter
  :args (s/cat :point ::points2d3d/point
               :radius number?)
  :ret (s/coll-of ::points2d3d/point))

(defn inside-filter [point radius]
  (if (is-inside? point radius)
    [point]
    []))

(s/fdef validate-radius
  :args (s/cat :radius number?)
  :ret (s/coll-of number?))

(defn validate-radius [radius]
  (if (pos? radius)
    [radius]
    []))
