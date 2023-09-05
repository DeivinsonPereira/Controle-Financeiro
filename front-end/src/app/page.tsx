import React from 'react';

export default function Home() {
  return (
    <div className='flex items-center justify-center w-screen h-screen bg-gradient-to-tr from-rose-800 to-red-400'>
      <section className='w-full max-w-5xl h-[600px] bg-slate-100 flex shadow-2xl'>
        {/* Parte com gradiente */}
        <div className='flex items-center justify-center w-2/3 text-white bg-gradient-to-b from-rose-800 to-red-400'>
          <h2 className='text-3xl font-semibold'>Bem-vindo!</h2>
        </div>

        {/* Parte com inputs */}
        <form className='flex items-center justify-center w-full p-8'>
          <div className='w-full max-w-sm space-y-4'>
            {/* <h2 className='mb-4 text-3xl font-semibold text-center text-rose-700'>Login</h2> */}
            <div>
              <label
                htmlFor='name'
                className='block text-sm font-medium text-rose-700'
              >
                Nome
              </label>
              <input
                type='text'
                id='name'
                name='name'
                placeholder='Seu Nome'
                className='block w-full mt-1 bg-transparent border-b sm:text-sm border-rose-400 focus:outline-none'
              />
            </div>
            <div>
              <label
                htmlFor='email'
                className='block text-sm font-medium text-rose-700'
              >
                Email
              </label>
              <input
                type='email'
                id='email'
                name='email'
                placeholder='seuemail@example.com'
                className='block w-full mt-1 bg-transparent border-b sm:text-sm border-rose-400 focus:outline-none'
              />
            </div>
            <div>
              <label
                htmlFor='password'
                className='block text-sm font-medium text-rose-700'
              >
                Senha
              </label>
              <input
                type='password'
                id='password'
                name='password'
                placeholder='Sua Senha'
                className='block w-full mt-1 bg-transparent border-b sm:text-sm border-rose-400 focus:outline-none'
              />
            </div>

            <div>
              <button className='w-full px-4 py-2 text-sm font-medium text-white bg-gradient-to-tl from-rose-800 to-red-400'>
                Entrar
              </button>
            </div>
          </div>
        </form>
      </section>
    </div>
  );
}
