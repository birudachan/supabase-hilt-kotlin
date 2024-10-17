package app.twentyhours.supabaseprototype.domain.usecase

interface UseCase<InputT, OutputT> {
    suspend fun execute(input: InputT): OutputT
}