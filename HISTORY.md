1.5-alpha3
 
* midje.repl namespace created (does not work for
  Clojure 1.2.X)
* Now reads ~/.midje.clj and .midje.clj for configuration.
  Configuration keys: :print-level, :visible-deprecation,
  :visible-future, :check-after-creation, :partial-prerequisites,
* Doc strings that explain the repl, midje, major topics.

* In failures, maps and sets are printed in sort order,
  which allows easier comparison of actual to expected
  results.
* The `has` collection predicate now works with collection
  and chatty checkers.
* The :check-only-at-load-time metadata was added.

1.5-alpha2
-------------
* Added `load-facts`

1.5-alpha1
-------------
* Facts are stashed and can be rechecked.
   https://github.com/marick/Midje/wiki/Rechecking-facts-in-the-repl
* Added code to warn (once) of deprecated features.
* `roughly` returns false for non-numbers instead of
  throwing an exception.
* `against-background` is only called once per fact (via
  Harri Salokorpi)
* `junit-report` can be used with Midje (via Paudi Moriarty)

1.4.0 
------------- 
See https://github.com/marick/Midje/wiki/New-in-1.4

1.3.1 
---------
* Fix mysterious type conversion error in some cases
  when midje has to try really hard to guess the line number.

1.3.0
--------
* Supports Clojure 1.3
* Syntax coloring
   https://github.com/marick/Midje/wiki/Colorizing
* Lazytest/autotest behavior
  https://github.com/marick/Midje/wiki/Lein-midje
* Alternate format for metaconstants uses dashes instead of dots: ---mc---
  This is useful if the metaconstant is to represent a function.
* Now considers metaconstants with different numbers of dots
  to be the same. That is: `(fact (f ..x..) => ...x..)` has
  two instances of the same metaconstant.
* Partial prerequisites
  https://github.com/marick/Midje/wiki/Partial-prerequisites
* Data prerequisites.
  https://github.com/marick/Midje/wiki/Data-prerequisites
* Now works properly with aot-compilation. More properly, at least.
* Prevents you from overriding functions that the compiler inlines.
  https://github.com/marick/Midje/issues/60
* =expands-to=> for testing macros (in a style derived from
  /Let Over Lambda/. (via Phil Calçado)
  https://github.com/marick/Midje/wiki/Macros

1.2
--------
*   Lein-midje has been split off into a separate project.
*   defrecord-openly and deftype-openly allows the use of
    `provided` with protocol functions.   https://github.com/marick/Midje/wiki/Prerequisites-and-protocols
*    You can now specify how often prerequisites should be
     called.   https://github.com/marick/Midje/wiki/Specifying-call-counts
*    Tabular facts
   https://github.com/marick/Midje/wiki/Tabular-facts
*    `fact` will now return true if all the checks succeed;  false otherwise.
*    Can use either Clojure 1.2.0 or 1.2.1
*    Plain functions within prerequisite arglists are now  implicitly wrapped with `exactly`.
*    Bugfix: `roughly` works when a single argument is negative.

1.1.1 
---------
* Background prerequisites are now scoped to facts. That  works better with let-bindings. (Issue 26)

1.1
--------
* Can defer individual checks in a fact with the =future=>  arrow.
  https://github.com/marick/Midje/wiki/Future-facts
* Negating arrows in facts (=not=>)
  https://github.com/marick/Midje/wiki/Negating-arrows
* Folded prerequisites are much more competent
  https://github.com/marick/Midje/wiki/Folded-prerequisites
* Some improvement in error reporting.
* The #'roughly checker can be used for inexact numerical comparisons. 
* #'irrelevant is a synonym for #anything
* Line numbers are better reported for failures of very stripped-down forms (like (fact 1 => odd?)
* A prerequisite like (f 1) =streams=> [1 2 3] produces  the next value each time it's called.
* Issue warning when bare function is used in a prerequisite. Behavior will change in 1.2.
* Several ways to make checkers that can be used in prerequisites.

1.0.1
-------------
* Ben Mabey fix: eagerly preserve record types
* Extended-= and collection checkers have semantics for mixing maps and records.

1.0.0
----------------
* Allow, where unambiguous, collection checkers to have multiple element arguments:

      (f) => (just  1 2 3 ) ; same as..
      (f) => (just [1 2 3])

* Unexpected exceptions are displayed with a trimmed stack trace
       FAIL at (t_collection.clj:427)
           Expected: 33
             Actual: java.lang.Error: Oops!
                     midje.checkers.t_collection$go.invoke(t_collection.clj:425)
                     midje.checkers.t_collection$eval4728$fn__4729.invoke(t_collection.clj:427)
                     midje.unprocessed$expect_STAR_$fn__2586$fn__2587.invoke(unprocessed.clj:69)
                     midje.unprocessed$expect_STAR_$fn__2586.invoke(unprocessed.clj:67)
                     midje.util.thread_safe_var_nesting$with_altered_roots_STAR_.invoke(thread_safe_var_nesting.clj:33)
                     midje.unprocessed$expect_STAR_.invoke(unprocessed.clj:66)
                     midje.checkers.t_collection$eval4728.invoke(t_collection.clj:426)
                     user$eval19.invoke(NO_SOURCE_FILE:1) 

* `lein midje` runs clojure.test deftests and integrates the results into the summary.

* `cake midje` does the same for Cake users.
