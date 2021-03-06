/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.auth;

// TODO: Move it out from firebase-common. Temporary host it their for
// database's integration.http://b/27624510.

// TODO: Decide if changing this not enforcing an error code. Need to align
// with the decision in http://b/27677218. Also, need to turn this into abstract later.

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.google.firebase.FirebaseException;
import com.google.firebase.internal.NonNull;

/**
 * Generic exception related to Firebase Authentication. Check the error code and message for more
 * details.
 */
public class FirebaseAuthException extends FirebaseException {

  private final String errorCode;

  public FirebaseAuthException(@NonNull String errorCode, @NonNull String detailMessage) {
    this(errorCode, detailMessage, null);
  }

  public FirebaseAuthException(@NonNull String errorCode, @NonNull String detailMessage,
                               Throwable throwable) {
    super(detailMessage, throwable);
    checkArgument(!Strings.isNullOrEmpty(errorCode));
    this.errorCode = errorCode;
  }

  /** Returns an error code that may provide more information about the error. */
  @NonNull
  public String getErrorCode() {
    return errorCode;
  }
}
