(ns midje.t-repl-helper
  (:use midje.sweet
        [midje.test-util]))

(fact "a simple test"
  (+ 1 2) => 3)

(fact "a non-featherian test" :non-featherian
  (cons 1 nil) => [1])
