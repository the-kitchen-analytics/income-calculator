package com.glebremniov.firebase;

public interface FirebaseTypeConverter<F, T> {

  /**
   * Converts a {@code Firebase} type to a {@code java} type.
   *
   * @param firebaseType the Firebase type object
   * @return the java type object
   */
  T toJavaType(F firebaseType);

  /**
   * Converts a {@code java} type to a {@code Firebase} type.
   *
   * @param javaType the java type object
   * @return the Firebase type object
   */
  F toFirebaseType(T javaType);


}
