package java8;

public interface Converter<F, T> {
  T convert(F from);
}