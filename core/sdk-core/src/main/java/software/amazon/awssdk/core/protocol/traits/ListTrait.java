/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.core.protocol.traits;

import software.amazon.awssdk.annotations.SdkProtectedApi;
import software.amazon.awssdk.core.protocol.SdkField;

/**
 * Trait that includes additional metadata about List members.
 */
@SdkProtectedApi
public final class ListTrait implements Trait {

    private final String memberLocationName;
    private final SdkField memberFieldInfo;

    private ListTrait(Builder builder) {
        this.memberLocationName = builder.memberLocationName;
        this.memberFieldInfo = builder.memberFieldInfo;
    }

    /**
     * Location name of member, this is typically only used for XML based protocols which use separate
     * tags for each item. This is not used for JSON and JSON-like protocols.
     *
     * @return Member location name.
     */
    public String memberLocationName() {
        return memberLocationName;
    }

    /**
     * @return Metadata about the items this list contains. May be further nested in the case of complex nested containers.
     */
    public SdkField memberFieldInfo() {
        return memberFieldInfo;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String memberLocationName;
        private SdkField memberFieldInfo;

        private Builder() {
        }

        public Builder memberLocationName(String memberLocationName) {
            this.memberLocationName = memberLocationName;
            return this;
        }

        public Builder memberFieldInfo(SdkField memberFieldInfo) {
            this.memberFieldInfo = memberFieldInfo;
            return this;
        }

        public ListTrait build() {
            return new ListTrait(this);
        }
    }
}
