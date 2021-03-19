# Java IO

> IO 是指 `Input/Output`，即输入和输出。以内存为中心：
> + `Input` 指**从外部读入数据到内存**，例如，从磁盘读取文件到内存，从网络读取数据到内存等等。
> + `Output` 指**把数据从内存输出到外部**，例如，把数据从内存写入到文件，把数据从内存输出到网络等等。
>
> Java 中，一般以 `byte` 和 `char` 表示 IO 数据流
> + 字节流：`InputStream`（输入字节流） / `OutputStream`（输出字节流）
> + 字符流：`Reader`（输入字符流） / `Writer`（输出字符流）

## 同步 IO 和 异步 IO

> 同步 IO 是指，读写 IO 时代码必须**等待数据返回**后才继续执行后续代码
> 
> 异步 IO 是指，读写 IO 时仅发出请求，然后立刻执行后续代码
> 
> Java 标准库的包 `java.io` 提供了同步 IO，而 `java.nio` 则是异步 IO

### File 和 Path