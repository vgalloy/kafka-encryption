/*-
 * #%L
 * Kafka Encryption
 * %%
 * Copyright (C) 2018 Quicksign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.quicksign.kafka.crypto.generatedkey;

import java.util.Optional;

import io.quicksign.kafka.crypto.encryption.KeyProvider;

public class PerRecordKeyProvider implements KeyProvider {

    private final MasterKeyEncryption masterKeyEncryption;

    public PerRecordKeyProvider(MasterKeyEncryption masterKeyEncryption) {

        this.masterKeyEncryption = masterKeyEncryption;
    }


    @Override
    public Optional<byte[]> getKey(byte[] keyRef) {
        return Optional.of(masterKeyEncryption.decryptKey(keyRef));
    }
}