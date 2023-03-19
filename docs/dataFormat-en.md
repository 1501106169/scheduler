# Test Data Format

 * [Chinese Manual](https://github.com/1501106169/scheduler/blob/master/docs/dataFormat.md)
 * [English Manual](https://github.com/1501106169/scheduler/blob/master/docs/dataFormat-en.md)

## Rules

### Real-Time Task

#### Periodic Task

Periodic tasks are represented using the quaternion ($\Phi$, $P$, $e$, $D$). The meaning of each of these symbols is as follows

 * $\Phi$ indicates the `phase` of the periodic task. `phase`refers to the `release time` of the first job in the task.
 * $P$ indicates the `periodic`. `periodic` refers to the minimum length of time between the release times of two jobs that are connected in a task.
 * $e$ refers to the `execution time` of a periodic task.
 * $D$ refers to the `relative deadline` of a periodic task. 

Example
```
(0, 40, 10, 40)
```

#### Aperiodic Task

Aperiodic task are rpresented using the triplet $ (r, \; e, \; d) $. The meaning of each of these symbols is as follows

 * $r$ indicates the `release time` of job. 
 * $e$ indicates the `execution time` of job. 
 * $d$ indicates the `absolute deadline` of job. 

Example
```
(100, 10, 150)
```

#### Sporadic Task

Sporadic task can also be represented using the triple $ (r, \; e, \; d) $. And, introduce `splitters` to write occasional tasks under `splitters`.

 * The `splitters` is `------SporadicTask------`.

Example
```
------SporadicTask------

(110, 10, 130)
```

### Storage Forms

 * Each group of real-time tasks is stored using a text file in the encoding format `UTF-8`.
 * The file can contain any `blank lines`, and `valid lines`, but can only contain one `splitters`.
 * Each `valid line` represents a real-time task containing `4` or `3` parameters, each separated by a `space` or `tab`.
 * Before the `splitter` *only* periodic and aperiodic tasks can be stored; after the `splitter` *only* sporadic tasks can be stored.

## Example

Below is a representation of the four periodic tasks, one aperiodic task and one sporadic task in the file.

```
0   40  10  40
0   50  18  50
0   200 10  200
0   200 20  200
100 10  150

------SporadicTask------

110 10  130

```

