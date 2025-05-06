package com.coderkot.chat.domain.model

data class Usage(
    val completion_tokens: Int,
    val prompt_cache_hit_tokens: Int,
    val prompt_cache_miss_tokens: Int,
    val prompt_tokens: Int,
    val prompt_tokens_details: PromptTokensDetails,
    val total_tokens: Int
)