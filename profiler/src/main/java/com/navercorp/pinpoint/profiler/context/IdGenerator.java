/*
 * Copyright 2014 NAVER Corp.
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

package com.navercorp.pinpoint.profiler.context;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author emeroad
 */
public class IdGenerator {
    
    public static final long INITIAL_TRANSACTION_ID = 0L;
    public static final long INITIAL_DISABLE_ID = -1000L;
    
    // Unique id for tracing a internal stacktrace and calculating a slow time of activethreadcount
    // moved here in order to make codes simpler for now
    private final AtomicLong transactionId = new AtomicLong(INITIAL_TRANSACTION_ID);
    // -1 is DEFAULT_DISABLE_ID
    private final AtomicLong disableId = new AtomicLong(INITIAL_DISABLE_ID);

    public long nextTransactionId() {
        return this.transactionId.getAndIncrement();
    }

    public long nextDisableId() {
        return this.disableId.getAndDecrement();
    }
    
    public long currentTransactionId() {
        return this.transactionId.get();
    }
    
    public long currentDisabledId() {
        return this.disableId.get();
    }
}
